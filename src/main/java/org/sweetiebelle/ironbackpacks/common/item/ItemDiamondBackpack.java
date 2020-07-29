package org.sweetiebelle.ironbackpacks.common.item;

import org.sweetiebelle.ironbackpacks.common.BackpackType;

public class ItemDiamondBackpack extends ItemBackpack {

    public ItemDiamondBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.DIAMOND;
    }

}
