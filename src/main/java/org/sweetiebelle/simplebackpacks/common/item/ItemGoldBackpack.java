package org.sweetiebelle.simplebackpacks.common.item;

import org.sweetiebelle.simplebackpacks.common.BackpackType;

public class ItemGoldBackpack extends ItemBackpack {

    public ItemGoldBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.GOLD;
    }

}
