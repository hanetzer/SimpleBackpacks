package org.sweetiebelle.ironbackpacks.common.item;

import org.sweetiebelle.ironbackpacks.common.BackpackType;

public class ItemGoldBackpack extends ItemBackpack {

    public ItemGoldBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.GOLD;
    }

}
