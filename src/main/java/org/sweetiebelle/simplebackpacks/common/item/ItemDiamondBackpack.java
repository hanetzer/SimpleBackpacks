package org.sweetiebelle.simplebackpacks.common.item;

import org.sweetiebelle.simplebackpacks.common.BackpackType;

public class ItemDiamondBackpack extends ItemBackpack {

    public ItemDiamondBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.DIAMOND;
    }

}
