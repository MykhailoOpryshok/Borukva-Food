package com.opryshok.entity;

import com.opryshok.BorukvaFood;
import com.opryshok.block.cooking.Pan;
import com.opryshok.sounds.SoundRegistry;
import com.opryshok.ui.GuiTextures;
import com.opryshok.ui.LedgerSimpleGui;
import com.opryshok.ui.LedgerSlot;
import com.opryshok.utils.MinimalSidedInventory;
import com.opryshok.utils.PanRecipes;
import eu.pb4.factorytools.api.block.BlockEntityExtraListener;
import eu.pb4.factorytools.api.block.entity.LockableBlockEntity;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Objects;


public class PanBlockEntity extends LockableBlockEntity implements MinimalSidedInventory, BlockEntityExtraListener, SidedInventory{
    private static final int[] SLOTS =  new int[]{0, 1, 2};
    public boolean active;
    private int soundTicks = 20;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private final HashMap<Integer, Integer> slotTick = new HashMap<>();
    {
        slotTick.put(0, 0);
        slotTick.put(1, 0);
        slotTick.put(2, 0);
    }
    private Pan.Model model;
    private static final int COOK_TIME = 100;
    public PanBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModEntities.PAN, blockPos, blockState);
    }
    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.writeNbt(nbt, lookup);
        Inventories.writeNbt(nbt, this.items, lookup);
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup lookup) {
        super.readNbt(nbt, lookup);
        Inventories.readNbt(nbt, this.items, lookup);
        if (this.model != null) {
            this.model.updateItems(this.getStacks());
        }
    }
    @Override
    public void markDirty() {
        super.markDirty();
        if (this.model != null) {
            this.model.updateItems(this.getStacks());
        }
    }
    public static <T extends BlockEntity> void tick(World world, BlockPos pos, BlockState state, T t) {
        if (t instanceof PanBlockEntity self) {
            self.active = state.get(Properties.LIT);
            if (self.active && !self.items.isEmpty()) {
                for (int i = 0; i < self.items.size(); i++) {
                    ItemStack stack = self.items.get(i);
                    if (!stack.isEmpty() && PanRecipes.RECIPES.containsKey(stack.getItem())) {
                        if(self.soundTicks >= 20){
                            world.playSound(null, pos, SoundRegistry.FRYING, SoundCategory.BLOCKS, 1f, 1f);
                            self.soundTicks = 0;
                        }
                        int tickCount = self.slotTick.getOrDefault(i, 0);
                        if (tickCount >= COOK_TIME * stack.getCount()) {
                            self.items.set(i, getCookedVariant(stack));
                            self.model.updateItems(self.getStacks());
                            self.slotTick.put(i, 0);
                        } else {
                            self.slotTick.put(i, tickCount + 1);
                        }
                    } else {
                        self.slotTick.put(i, 0);
                    }
                }
                self.soundTicks++;
            }
        }
    }
    public static ItemStack getCookedVariant(ItemStack stack){
        Item cookedItem = PanRecipes.RECIPES.get(stack.getItem());
        return new ItemStack(cookedItem, stack.getCount());
    }
    @Override
    public DefaultedList<ItemStack> getStacks() {
        return items;
    }
    @Override
    public int[] getAvailableSlots(Direction side) {
        return SLOTS;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }
    @Override
    protected void createGui(ServerPlayerEntity playerEntity) {
        new PanBlockEntity.Gui(playerEntity);
    }

    @Override
    public void onListenerUpdate(WorldChunk chunk) {
        try {
            this.model = (Pan.Model) Objects.requireNonNull(BlockAwareAttachment.get(chunk, this.getPos())).holder();
            this.model.updateItems(this.items);
        } catch (Throwable e) {
            BorukvaFood.LOGGER.debug("error: ", e);
        }

    }

    public class Gui extends LedgerSimpleGui {
        public Gui(ServerPlayerEntity player) {
            super(ScreenHandlerType.GENERIC_9X2, player, false);
            this.setTitle(GuiTextures.PAN.apply(Text.literal("Пательня")));

            this.setSlotRedirect(3, new LedgerSlot(pos, player, PanBlockEntity.this, 0, 0, 0));
            this.setSlotRedirect(4, new LedgerSlot(pos, player, PanBlockEntity.this,  1, 1, 0));
            this.setSlotRedirect(5, new LedgerSlot(pos, player, PanBlockEntity.this, 2, 2, 0));

            this.setSlot(13, GuiTextures.FLAME.get(PanBlockEntity.this.active ? 1 : 0));

            this.open();
        }
        @Override
        public void onTick() {
            if (player.getPos().squaredDistanceTo(Vec3d.ofCenter(PanBlockEntity.this.pos)) > (18 * 18)) {
                this.close();
            }
            this.setSlot(13, GuiTextures.FLAME.get(PanBlockEntity.this.active ? 1 : 0));
            super.onTick();
        }
    }
}
