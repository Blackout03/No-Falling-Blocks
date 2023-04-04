package com.blackout.nofallingblocks.mixins;

import com.blackout.nofallingblocks.NoFallingBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FallingBlock.class)
public abstract class FallingBlockMixin extends Block {
	public FallingBlockMixin(Properties properties) {
		super(properties);
	}

	@Inject(method = "tick", at = @At("HEAD"), cancellable = true)
	private void cancelFalling(BlockState blockState, ServerLevel level, BlockPos blockPos, RandomSource randomSource, CallbackInfo callbackInfo) {
		if (level.getGameRules().getRule(NoFallingBlocks.PREVENT_BLOCK_FALLING_RULE).get()) {
			callbackInfo.cancel();
		}
	}

	@Inject(method = "animateTick", at = @At("HEAD"), cancellable = true)
	private void cancelFallingParticle(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource, CallbackInfo callbackInfo) {
		if (level.getGameRules().getRule(NoFallingBlocks.PREVENT_BLOCK_FALLING_RULE).get()) {
			callbackInfo.cancel();
		}
	}
}
