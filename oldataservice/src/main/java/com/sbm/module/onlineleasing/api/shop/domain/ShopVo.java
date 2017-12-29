package com.sbm.module.onlineleasing.api.shop.domain;

import com.sbm.module.common.business.domain.BaseEntity;
import com.sbm.module.common.business.domain.Pagination;
import com.sbm.module.onlineleasing.base.shop.domain.TOLShop;
import com.sbm.module.onlineleasing.base.shopcoords.domain.TOLShopCoords;
import com.sbm.module.onlineleasing.base.shopimages.domain.TOLShopImages;

import java.util.List;

public class ShopVo {

    private Pagination<TOLShop> pagination;

    private TOLShop shop;

    private List<TOLShopImages> images;

    private TOLShopCoords coords;

    public Pagination<TOLShop> getPagination() {
        return pagination;
    }

    public void setPagination(Pagination<TOLShop> pagination) {
        this.pagination = pagination;
    }

    public TOLShop getShop() {
        return shop;
    }

    public void setShop(TOLShop shop) {
        this.shop = shop;
    }

    public List<TOLShopImages> getImages() {
        return images;
    }

    public void setImages(List<TOLShopImages> images) {
        this.images = images;
    }

    public TOLShopCoords getCoords() {
        return coords;
    }

    public void setCoords(TOLShopCoords coords) {
        this.coords = coords;
    }
}
