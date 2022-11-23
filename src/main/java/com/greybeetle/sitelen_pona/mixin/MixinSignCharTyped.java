package com.greybeetle.sitelen_pona.mixin;

import com.greybeetle.sitelen_pona.StringToSP;
import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.font.TextFieldHelper;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;
import java.util.function.Supplier;

@Mixin(TextFieldHelper.class)
public abstract class MixinSignCharTyped {
    @Shadow private int cursorPos;
    @Shadow @Final private Supplier<String> getMessageFn;

    protected MixinSignCharTyped() {
        setMessageFn = null;
    }

    @Inject(at= @At(value = "HEAD"), method = "charTyped", cancellable = true)
    private void charTyped(char p_95144_, CallbackInfoReturnable<Boolean> cir){
        if (SharedConstants.isAllowedChatCharacter(p_95144_)) {
            this.insertText(this.getMessageFn.get(), Character.toString(p_95144_));
            this.setMessageFn.accept(StringToSP.SubstituteSitelen(this.getMessageFn.get()));
            this.setCursorToEnd();

        }

        cir.setReturnValue(true);

    }

    @Shadow private final Consumer<String> setMessageFn;
    @Shadow public void setCursorToEnd(){};
    @Shadow
    private void insertText(String p_95161_, String p_95162_) {}
}
