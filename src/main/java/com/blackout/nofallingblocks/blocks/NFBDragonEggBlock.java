package com.blackout.nofallingblocks.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class NFBDragonEggBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public NFBDragonEggBlock(AbstractBlock.Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        this.teleport(state, worldIn, pos);
        return ActionResultType.sidedSuccess(worldIn.isClientSide);
    }

    public void attack(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        this.teleport(state, worldIn, pos);
    }

    private void teleport(BlockState state, World world, BlockPos pos) {
        for(int i = 0; i < 1000; ++i) {
            BlockPos blockpos = pos.offset(world.random.nextInt(16) - world.random.nextInt(16), world.random.nextInt(8) - world.random.nextInt(8), world.random.nextInt(16) - world.random.nextInt(16));
            if (world.getBlockState(blockpos).isAir()) {
                if (world.isClientSide) {
                    for(int j = 0; j < 128; ++j) {
                        double d0 = world.random.nextDouble();
                        float f = (world.random.nextFloat() - 0.5F) * 0.2F;
                        float f1 = (world.random.nextFloat() - 0.5F) * 0.2F;
                        float f2 = (world.random.nextFloat() - 0.5F) * 0.2F;
                        double d1 = MathHelper.lerp(d0, blockpos.getX(), pos.getX()) + (world.random.nextDouble() - 0.5D) + 0.5D;
                        double d2 = MathHelper.lerp(d0, blockpos.getY(), pos.getY()) + world.random.nextDouble() - 0.5D;
                        double d3 = MathHelper.lerp(d0, blockpos.getZ(), pos.getZ()) + (world.random.nextDouble() - 0.5D) + 0.5D;
                        world.addParticle(ParticleTypes.PORTAL, d1, d2, d3, f, f1, f2);
                    }
                } else {
                    world.setBlock(blockpos, state, 2);
                    world.removeBlock(pos, false);
                }

                return;
            }
        }

    }

    public boolean isPathfindable(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return false;
    }
}
