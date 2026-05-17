package com.example.mixin;

import net.minecraft.block.entity.SignBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SignBlockEntity.class)
public class ExampleMixin {
    @Inject(method = "openTextEditor", at = @At("HEAD"), cancellable = true)
    private void onOpenTextEditor(PlayerEntity player, boolean front, CallbackInfoReturnable<Boolean> cir) {
        if (player.isSneaking()) {
            cir.setReturnValue(false);
        }
    }
}
