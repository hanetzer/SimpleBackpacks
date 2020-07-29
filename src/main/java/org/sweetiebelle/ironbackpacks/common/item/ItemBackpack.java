package org.sweetiebelle.ironbackpacks.common.item;

import org.sweetiebelle.ironbackpacks.common.BackpackType;
import org.sweetiebelle.ironbackpacks.common.container.BackpackContainerProvider;
import org.sweetiebelle.ironbackpacks.common.sounds.BackpackSounds;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class ItemBackpack extends Item {

    public ItemBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack held = player.getHeldItem(hand);
        world.playSound(player, new BlockPos(player), BackpackSounds.OPEN_SOUND.get(), SoundCategory.PLAYERS, 1.0F, 1.0F);
        player.openContainer(new BackpackContainerProvider(held));
        return ActionResult.resultSuccess(held);
    }

    public abstract BackpackType getType();
    
    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged;
    }

}
