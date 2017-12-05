
   
     <div class="mainmenu-area">
        <div class="container">
            <div class="row">
           <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div> 
                <div class="navbar-collapse collapse" ng-init="activeCategoryCode='FMCG'">
                    <ul class="nav navbar-nav">
                        <li ng-click="getItemList('FMCG')" ng-class="{active:activeCategoryCode=='FMCG'}"><a href="#">Fast-moving consumer goods</a>
                        <li ng-click="getItemList('STAT')" ng-class="{active:activeCategoryCode=='STAT'}"><a href="#">Stationery Items</a>
                        <li ng-click="getItemList('CERL')" ng-class="{active:activeCategoryCode=='CERL'}"><a href="#">Cereals foods</a>
                        <li ng-click="getItemList('PETC')" ng-class="{active:activeCategoryCode=='PETC'}"><a href="#">Pet Care food</a>
                        
                      	
                      
                    </ul>
                    
                    <button ng-show="false" type="button" value="Go to Review Page" ng-click="ctrl.reviewOrder()" class="btn btn-success custom-width">Go to Review Page After Add to Cart</button>
                        
                         <div class="" ng-click="ctrl.reviewOrder();" style="float:right;margin-bottom:10px;">
                    		<div class="shopping-item">
                       		 <a>Cart - <span class="cart-amunt"></span> <i class="fa fa-shopping-cart"></i> <span class="product-count">{{ctrl.productCount}}</span></a>
                        	</div>
                    	</div>
                </div>  
            </div>
        </div>
    </div> <!-- End mainmenu area -->
    
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h1></h1>
                    </div>
                </div>
            </div>
        </div>
    </div>