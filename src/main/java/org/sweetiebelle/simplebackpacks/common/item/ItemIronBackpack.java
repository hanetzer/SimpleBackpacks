package org.sweetiebelle.simplebackpacks.common.item;

import org.sweetiebelle.simplebackpacks.common.BackpackType;

public class ItemIronBackpack extends ItemBackpack {

    public ItemIronBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.GOLD;
    }

}
