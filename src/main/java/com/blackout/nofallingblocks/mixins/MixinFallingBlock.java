package com.blackout.nofallingblocks.mixins;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(FallingBlock.class)
public abstract class MixinFallingBlock extends Block {
	public MixinFallingBlock(Properties properties) {
		super(properties);
	}

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	private void cancelFalling(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
		ci.cancel();
	}

	@Inject(method = "animateTick", at = @At("HEAD"), cancellable = true)
	private void cancelFallingParticle(BlockState state, World world, BlockPos pos, Random random, CallbackInfo ci) {
		ci.cancel();
	}
}
