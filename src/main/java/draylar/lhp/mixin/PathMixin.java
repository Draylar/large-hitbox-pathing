package draylar.lhp.mixin;

import draylar.lhp.api.LargePathing;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.Path;
import net.minecraft.entity.ai.pathing.PathNode;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(Path.class)
public class PathMixin {

    @Shadow @Final private List<PathNode> nodes;

    /**
     * @author Draylar
     * @reason fixes pathing for >=1.0 width entities
     */
    @Inject(method = "getNodePosition(Lnet/minecraft/entity/Entity;I)Lnet/minecraft/util/math/Vec3d;", at = @At("HEAD"), cancellable = true)
    public void getNodePosition(Entity entity, int index, CallbackInfoReturnable<Vec3d> cir) {
        if (entity instanceof LargePathing) {
            PathNode pathNode = nodes.get(index);
            double d = (double) pathNode.x + 0.5;
            double e = pathNode.y;
            double f = (double) pathNode.z + 0.5;
            cir.setReturnValue(new Vec3d(d, e, f));
        }
    }
}
