package org.sweetiebelle.ironbackpacks.common.item;

import org.sweetiebelle.ironbackpacks.common.BackpackType;

public class ItemIronBackpack extends ItemBackpack {

    public ItemIronBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.GOLD;
    }

}
