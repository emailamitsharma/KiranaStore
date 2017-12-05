<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>My Kirana Store</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
</head><!--/head-->

<body>		
	<section id="cart_items">
		<div class="container">			
			<div class="table cart_info">
				<form id="quantityForm" name="quantityForm">
				<table class="table table">
					<thead>
						<tr class="cart_menu">
							<td class="image">Item</td>
							<td class="description"></td>
							<td class="price">Price</td>
							<td class="quantity">Quantity</td>
							<td class="total">Total</td>
							<td class="action"></td>
							<td class="action"></td>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="item in cartItems" id="item-{{$index}}" ng-class="{'active':true}" ng-click="">
							<td class="cart_product">
								<a href=""><img height="20%" width="25%" src="/KiranaStore/img/{{item.miniImageURL}}" 
alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">{{item.categoryCode}}</a></h4>
								<p>CODE ID: {{item.code}}</p>
							</td>
							<td class="cart_price">
								<p>{{item.price}}</p>
							</td>
							<td ng-class="cart_quantity">
								<div class="cart_quantity_button">
									<input  ng-model="item.quantity" class="cart_quantity_input" type="number" name="quantity" 
value="{{item.quantity}}" autocomplete="off"  min="0" max="{{item.itemUnitCount}}" required>									
								</div>
								<span ng-if="item.quantity == undefined || item.quantity > item.itemUnitCount" style="color:red">You cannot select more than {{item.itemUnitCount}} of this product</span>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">{{item.finalPrice}}</p>
							</td>
							<td class="cart_action">
							<a style="float: left!important;" ng-click="updateQuantityChanges(item);" class="btn btn-default update">Update Quantity 
Changes</a>							
							</td>
							<td class="">
								<a ng-click="deleteItem(item);" class=""><i class="fa fa-times"></i></a>
							</td>
							
						</tr>				
					</tbody>
					
				</table>
				</form>
								<p>Your discounted offers have been already applied</p>
				
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>Provide Delivery Details</h3>
			</div>
			<div class="row">
			
				<div class="col-sm-6">
									  <form id="registerForm" class="form-horizontal" action="registration" method="post">

					<div class="chose_area">
					  <div style="margin-left:30px;">
					  
			Customer Details
					  
      

								  		<div class="form-group">
										   <label class="col-sm-19" id="kirana_lb_user_Name" for="name">
										       Name
										      <em class="required">*</em>
										   </label>
										   <div class="col-sm-20">
										      <input ng-model="cust.name" id="name" name="cust.name" class="maxAlert margin0" 
type="text" value="" maxlength="15"/>
										      <div class="error" id="err_name">
										         
										      </div>
										   </div>
										</div>
										
											<div class="form-group">
										   <label class="col-sm-19" id="kirana_lb_user_address" for="address">Delievery 
Address</label>
										   <div class="col-sm-20">
										      <input ng-model="cust.address" id="st_address" name="st_address" 
class="maxAlert margin0" type="text" value="" maxlength="50"/>
										      <div class="error" id="error-message2" style="display:none;">
										         <div id="err_st_address"></div>
										      </div>
										      
										   </div>
										</div>
										
										 <div class="form-group">
								            <label class="col-sm-19" id="cvty_lb_user_mobile" for="emailAgain">Mobile 
Number<em class="required">*</em></label>
								            <div class="col-sm-20"><input ng-model="cust.mobile" id="mobile" name="mobile" 
type="text" value="" maxlength="100"/>
								            <div class="error" id="err_emailAgain">
							             </div>
              </div>
          </div>
										
							
							          
							      <div>
					</div>
					</div>
					
					   <ul class="user_option">
					   
					   
						  <input ng-model="order.deliveryMode" type="radio" name="deliveryMode" value="PickUP" ng-click="updateShippingCharges('PickUp')"> Take Away<br>
  						  <input ng-model="order.deliveryMode" type="radio" name="deliveryMode" value="HomeDelivery" ng-click="updateShippingCharges('HomeDelivery')"> Home Delivery (Charges: Rs. 30 
extra)
<div ng-show="shippingModeApplied == 'H'" style="margin-top:10px;">Your shipment will be available by {{order.deliveryDate}}. Delivery person would call you for time co-ordination.</div>
					</ul>
					</div>
					</form>
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>Cart Total <span>Rs. {{order.cartTotal}}</span></li>
							<li>CESS Tax <span>Rs. {{order.taxCharges}}</span></li>
							<li>Shipping Cost <span>Rs. {{order.shippingCost}}</span></li>
							<li>Total <span>Rs. {{order.total}}</span></li>
						</ul>
					</div>
												<a style="float:right;" class="btn btn-default check_out" ng-click="submitOrder();">Confirm Order</a>
					
				</div>
			</div>
		</div>
	</section>

    <script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</body>
</html>