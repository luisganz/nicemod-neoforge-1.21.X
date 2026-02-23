package de.redstoner_zockt.minecraftplus.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SteakPlateSlicedBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<SteakPlateSlicedBlock> CODEC = simpleCodec(SteakPlateSlicedBlock::new);
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 2, 14);

    public SteakPlateSlicedBlock(Properties properties) {
        super(properties.noOcclusion());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }
}
