package com.opryshok.block;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.HashMap;
import java.util.Map;

import static eu.pb4.polymer.blocks.api.BlockModelType.*;
import static eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils.requestBlock;
import static net.minecraft.state.property.Properties.BLOCK_HALF;

public class PolyTrapdoorBlock extends TrapdoorBlock implements PolymerTexturedBlock {
    private final BlockState[] TOP_TRAPDOORS = new BlockState[4];
    private final BlockState[] BOTTOM_TRAPDOORS = new BlockState[4];
    private final Map<Direction, BlockState> OPEN_TRAPDOORS_BOTTOM = new HashMap<>();
    private final Map<Direction, BlockState> OPEN_TRAPDOORS_BOTTOM_WATERLOGGED = new HashMap<>();

    private final Map<Direction, BlockState> OPEN_TRAPDOORS_TOP = new HashMap<>();
    private final Map<Direction, BlockState> OPEN_TRAPDOORS_TOP_WATERLOGGED = new HashMap<>();

    private final Identifier id;

    public PolyTrapdoorBlock(Settings settings) {
        super(BlockSetType.OAK, settings);
        this.id = Identifier.tryParse(this.getTranslationKey().replace("block.", "").replace(".", ":"));

        for (Direction dir : Direction.Type.HORIZONTAL.stream().toList()) {
            int y_rotation = (int) dir.getPositiveHorizontalDegrees() - 180;

            BlockModelType modelType = switch (dir) {
                case NORTH -> NORTH_TRAPDOOR;
                case WEST -> WEST_TRAPDOOR;
                case SOUTH -> SOUTH_TRAPDOOR;
                default -> EAST_TRAPDOOR;
            };
            BlockModelType modelTypeWaterlogged = switch (dir) {
                case NORTH -> NORTH_TRAPDOOR_WATERLOGGED;
                case WEST -> WEST_TRAPDOOR_WATERLOGGED;
                case SOUTH -> SOUTH_TRAPDOOR_WATERLOGGED;
                default -> EAST_TRAPDOOR_WATERLOGGED;
            };

            OPEN_TRAPDOORS_BOTTOM.put(dir, requestBlock(modelType, getModel("open", 0, y_rotation)));
            OPEN_TRAPDOORS_BOTTOM_WATERLOGGED.put(dir, requestBlock(modelTypeWaterlogged, getModel("open", 0, y_rotation)));

            OPEN_TRAPDOORS_TOP.put(dir, requestBlock(modelType, getModel("open", 180, y_rotation)));
            OPEN_TRAPDOORS_TOP_WATERLOGGED.put(dir, requestBlock(modelTypeWaterlogged, getModel("open", 180, y_rotation)));
        }

        for (int i = 0; i < 4; i++) {
            TOP_TRAPDOORS[i] = requestBlock(i < 3 ? TOP_TRAPDOOR : TOP_TRAPDOOR_WATERLOGGED, getModel("top", 0, i % 2 == 1 ? 90 : 0));
            BOTTOM_TRAPDOORS[i] = requestBlock(i < 3 ? BOTTOM_TRAPDOOR : BOTTOM_TRAPDOOR_WATERLOGGED, getModel("bottom", 0, i % 2 == 1 ? 90 : 0));
        }
    }

    private PolymerBlockModel getModel(String type, int x, int y) {
        return PolymerBlockModel.of(Identifier.of(id.getNamespace(), "block/%s_%s".formatted(id.getPath(), type)), x, y);
    }

    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, PacketContext context) {
        return Blocks.OAK_TRAPDOOR.getDefaultState();
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state, PacketContext context) {
        boolean waterlogged = state.get(WATERLOGGED);
        Direction facing = state.get(FACING);
        BlockHalf half = state.get(BLOCK_HALF);

        if (state.get(Properties.OPEN)) {
            if (half == BlockHalf.TOP) {
                return waterlogged ? OPEN_TRAPDOORS_TOP_WATERLOGGED.get(facing) : OPEN_TRAPDOORS_TOP.get(facing);
            } else {
                return waterlogged ? OPEN_TRAPDOORS_BOTTOM_WATERLOGGED.get(facing) : OPEN_TRAPDOORS_BOTTOM.get(facing);
            }
        } else {
            int modelIndex = (facing == Direction.NORTH || facing == Direction.SOUTH) ? 0 : 1;
            if (waterlogged) modelIndex += 2;
            return half == BlockHalf.TOP ? TOP_TRAPDOORS[modelIndex] : BOTTOM_TRAPDOORS[modelIndex];
        }
    }
}