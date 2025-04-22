package com.opryshok.block.cooking;

import com.mojang.serialization.MapCodec;
import com.opryshok.BorukvaFood;
import com.opryshok.block.ModBlocks;
import com.opryshok.entity.PanBlockEntity;
import com.opryshok.utils.TransparentBlocks.TransparentTripWire;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;
import xyz.nucleoid.packettweaker.PacketContext;

public class Pan extends BlockWithEntity implements TransparentTripWire, FactoryBlock, BlockEntityProvider, InventoryProvider {
    public static final BooleanProperty LIT;
    public static final EnumProperty<Direction> FACING;
    public static final MapCodec<Pan> CODEC;
    private Model model;

    static {
        FACING = Properties.HORIZONTAL_FACING;
        LIT = Properties.LIT;
        CODEC = createCodec(Pan::new);
    }

    public Pan(Settings settings) {
        super(settings.nonOpaque());
        this.setDefaultState(getDefaultState().with(LIT, false));
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.IRON_TRAPDOOR.getDefaultState();
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockState stoveState = world.getBlockState(ctx.getBlockPos().down());
        if (stoveState.isOf(ModBlocks.STOVE)) {
            return this.getDefaultState().with(LIT, stoveState.get(LIT)).with(FACING, ctx.getHorizontalPlayerFacing());
        }
        return this.getDefaultState().with(LIT, false).with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PanBlockEntity(pos, state);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!player.isSneaking() && world.getBlockEntity(pos) instanceof PanBlockEntity entity) {
            entity.openGui((ServerPlayerEntity) player);
            return ActionResult.SUCCESS;
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        var inv = world.getBlockEntity(pos);
        return inv instanceof SidedInventory ? (SidedInventory) inv : null;
    }

    @Override
    protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        ItemScatterer.onStateReplaced(state, world, pos);
        super.onStateReplaced(state, world, pos, moved);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
        super.appendProperties(builder);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return PanBlockEntity::tick;
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        model = new Model(initialBlockState, world, pos);
        return model;
    }

    @Override
    public boolean tickElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        this.model.tick();
        return true;
    }

    public static final class Model extends BlockModel {
        public static final ItemStack MODEL = ItemDisplayElementUtil.getModel(Identifier.of(BorukvaFood.MOD_ID, "block/pan"));
        public ItemDisplayElement[] items = new ItemDisplayElement[3];
        public ItemDisplayElement pan;
        public ServerWorld world;
        public BlockPos pos;
        public int tickCounter = 0;

        public Model(BlockState state, ServerWorld world, BlockPos pos) {
            this.world = world;
            this.pos = pos;
            init(state);
        }

        public void init(BlockState state) {
            this.pan = ItemDisplayElementUtil.createSimple(MODEL);
            this.pan.setTranslation(new Vector3f(0, 0, -0.49f));
            this.pan.setScale(new Vector3f(0.7f));
            this.pan.setDisplaySize(1f, 1f);
            this.updateStatePos(state);
            this.addElement(pan);
            for (int i = 0; i < 3; i++) {
                var item = ItemDisplayElementUtil.createSimple();
                item.setDisplaySize(1, 1);
                item.setScale(new Vector3f(0.4f));
                item.setPitch(90f + 180f);
                items[i] = item;
            }

            items[0].setTranslation(new Vector3f(-0.2f, -0.2f, -0.4f));
            items[1].setTranslation(new Vector3f(0.2f, -0.2f, -0.4f));
            items[2].setTranslation(new Vector3f(0, 0.2f, -0.4f));

            for (var item : items) {
                this.addElement(item);
            }
        }

        private void updateStatePos(BlockState state) {
            var direction = state.get(FACING);
            this.pan.setYaw(direction.getPositiveHorizontalDegrees());
            this.pan.setPitch(90f + 180f);
        }

        public void setItem(int i, ItemStack stack) {
            this.items[i].setItem(stack.copy());
            this.items[i].tick();
        }

        public void updateItems(DefaultedList<ItemStack> stacks) {
            for (int i = 0; i < 3; i++) {
                setItem(i, stacks.get(i));
            }
        }


        @Override
        protected void onTick() {
            if (tickCounter >= 100) {
                spawnParticles(pos);
                tickCounter = 0;
            } else {
                tickCounter++;
            }
        }

        private void spawnParticles(BlockPos pos) {
            if (world.getBlockState(pos).isOf(ModBlocks.PAN)) {
                if (world.getBlockState(pos).get(LIT)) {
                    for (int i = 0; i < 5; i++) {
                        world.spawnParticles(ParticleTypes.CAMPFIRE_COSY_SMOKE,
                                pos.getX() + 0.5,
                                pos.getY() + 1,
                                pos.getZ() + 0.5,
                                1, 0.15, 0.4, 0.15, 0);
                    }
                }
            }
        }
    }
}
