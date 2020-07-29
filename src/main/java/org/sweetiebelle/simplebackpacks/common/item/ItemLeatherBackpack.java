package org.sweetiebelle.simplebackpacks.common.item;

import org.sweetiebelle.simplebackpacks.common.BackpackType;

public class ItemLeatherBackpack extends ItemBackpack {

    public ItemLeatherBackpack(Properties properties) {
        super(properties);
    }

    @Override
    public BackpackType getType() {
        return BackpackType.LEATHER;
    }

}
