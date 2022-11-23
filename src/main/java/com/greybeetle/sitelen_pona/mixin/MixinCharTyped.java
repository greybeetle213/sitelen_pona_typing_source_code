package com.greybeetle.sitelen_pona.mixin;

import com.greybeetle.sitelen_pona.StringToSP;
import net.minecraft.SharedConstants;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.components.EditBox;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EditBox.class)
public abstract class MixinCharTyped {
    @Inject(at= @At(value = "HEAD"), method = "charTyped", cancellable = true)
    private void charTyped(char p_94122_, int p_94123_, CallbackInfoReturnable<Boolean> cir){
        EditBox E = (EditBox) ((Object)this);
        if (!E.canConsumeInput()) {
            cir.setReturnValue(false);
        } else if (SharedConstants.isAllowedChatCharacter(p_94122_)) {
            if (this.isEditable) {
                E.insertText(Character.toString(p_94122_));
            }
            E.setValue(StringToSP.SubstituteSitelen(E.getValue()));
            cir.setReturnValue(true);
        } else {
            cir.setReturnValue(false);
        }

    }

    @Shadow private boolean isEditable;
}
