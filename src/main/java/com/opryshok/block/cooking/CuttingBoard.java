package com.opryshok.block.cooking;

import com.mojang.serialization.MapCodec;
import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.entity.CuttingBoardBlockEntity;
import com.opryshok.item.ModItems;
import com.opryshok.utils.BorukvaFoodUtil;
import com.zefir.borukvautils.block.FlatTripwireBased;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class CuttingBoard extends BlockWithEntity implements FlatTripwireBased, FactoryBlock, BlockEntityProvider, InventoryProvider {
    public static DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final MapCodec<CuttingBoard> CODEC = createCodec(CuttingBoard::new);
    private Model model;
    public CuttingBoard(Settings settings) {
        super(settings.nonOpaque());
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.OAK_TRAPDOOR.getDefaultState();
    }
    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CuttingBoardBlockEntity(pos, state);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        var inv = world.getBlockEntity(pos);
        return inv instanceof SidedInventory ? (SidedInventory) inv : null;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ActionResult result = ActionResult.PASS;

        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof CuttingBoardBlockEntity cuttingBoardBlockEntity)) {
            return result;
        }

        ItemStack itemHeld = player.getStackInHand(player.getActiveHand());

        if (cuttingBoardBlockEntity.isEmpty()) {
            result = tryAddItemFromPlayerHand(world, cuttingBoardBlockEntity, player);
        } else if (itemHeld.isOf(ModItems.KNIFE)) {
            result = tryProcessCuttingUsingToolInHand(world, cuttingBoardBlockEntity, player);
        } else if (player.isSneaking()) {
            pullOutItemWithPlayer(world, cuttingBoardBlockEntity, player);
            result = ActionResult.SUCCESS;
        }
        return result;
    }
    private ActionResult tryAddItemFromPlayerHand(World world, CuttingBoardBlockEntity cuttingBoardBlockEntity, PlayerEntity player) {
        ItemStack itemHeld = player.getMainHandStack();
        ItemStack copy = itemHeld.copyWithCount(1);

        if (itemHeld.isEmpty() || itemHeld.isOf(ModItems.KNIFE) || itemHeld.isOf(ModBlocks.CUTTING_BOARD_ITEM)) {
            return ActionResult.PASS;
        } else if (cuttingBoardBlockEntity.addItem(player.getAbilities().creativeMode ? itemHeld.copy() : itemHeld)) {
            world.playSound(null, cuttingBoardBlockEntity.getPos(), SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.f, .8f);

            BorukvaFoodUtil.ledgerMixinInvoke();

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    private ActionResult tryProcessCuttingUsingToolInHand(World world, CuttingBoardBlockEntity cuttingBoardBlockEntity, PlayerEntity player) {
        ItemStack itemHeld = player.getStackInHand(player.getActiveHand());

        if (cuttingBoardBlockEntity.processItemUsingTool(world, itemHeld, player)) {
            return ActionResult.SUCCESS;
        }

        return ActionResult.CONSUME;
    }

    private void pullOutItemWithPlayer(World world, CuttingBoardBlockEntity cuttingBoardBlockEntity, PlayerEntity player) {
        BlockPos pos = cuttingBoardBlockEntity.getPos();

        BorukvaFoodUtil.ledgerMixinInvoke();

        ItemScatterer.spawn(world, player.getX(), player.getY(), player.getZ(), cuttingBoardBlockEntity.getItemStack());
        cuttingBoardBlockEntity.removeItem();
        cuttingBoardBlockEntity.markDirty();

        world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_HIT, SoundCategory.BLOCKS, .25f, .5f);
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        ItemScatterer.onStateReplaced(state, newState, world, pos);
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        model = new Model(initialBlockState);
        return model;
    }

    @Override
    public boolean tickElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        model.tick();
        return true;
    }

    public static class Model extends BlockModel {
        public static final ItemStack MODEL = BaseItemProvider.requestModel(Identifier.of(BorukvaFood.MOD_ID, "block/cutting_board"));
        public ItemDisplayElement item;
        public ItemDisplayElement main;
        public Model(BlockState state){
            init(state);
        }
        public void init(BlockState state){
            main = ItemDisplayElementUtil.createSimple(MODEL);
            var direction = state.get(FACING);
            main.setYaw(direction.asRotation());
            main.setScale(new Vector3f(1));
            addElement(main);

            item = ItemDisplayElementUtil.createSimple();
            item.setDisplaySize(1f, 1f);
            item.setScale(new Vector3f(0.6f));
            item.setTranslation(new Vector3f(0, 0.1f, -0.45f));
            item.setPitch(90f+180f);
            item.setYaw(direction.asRotation());
            addElement(item);
        }
        public void updateItem(ItemStack stack) {
            this.item.setItem(stack.copy());
            this.item.tick();
        }
    }
}
