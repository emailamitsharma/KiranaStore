<#include "/common/navigation.ftl">

    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-sm-6" ng-repeat="item in items">
                    <div class="single-shop-product">
                        <div class="product-upper">
                            <img src="/KiranaStore/img/{{item.miniImageURL}}" alt="">
                        </div>
                        <h2><a href="">{{item.name}}</a></h2>
                        <div class="product-carousel-price">
                            <ins>{{item.price}}</ins> <del>{{item.discountedPrice}}</del>
                        </div>  
                        
                        <div class="product-option-shop" >
                            <button type="submit" class="add_to_cart_button" data-quantity="1" data-product_sku="" 
                            data-product_id="70" rel="nofollow" ng-click="ctrl.addToCart(item);" ng-hide="ctrl.isLimitOfItemReached(item)">Add to cart</button>
                             <button type="" disabled"true" value="Added To Cart" ng-show="ctrl.isItemInCart(item)" class="btn btn-success custom-width">Added To Cart</button>
                            <span ng-if="ctrl.isLimitOfItemReached(item)" style="color:red">You cannot select more than {{item.itemUnitCount}} of this product</span>                            
                                                        
                        </div>                                        
                    </div>
                </div>
              
            </div>        
        </div>
    </div>