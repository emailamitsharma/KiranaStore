'use strict';

angular.module('kiranaApp').controller('categoryController',
    ['UserService' ,'ItemService', '$scope','$state','$rootScope',  function( UserService,ItemService, $scope, $state,$rootScope) {

        var self = this;
        self.user = {};
        self.users=[];
        self.productCount=0;
        self.submit = submit;
        self.getAllUsers = getAllUsers;
        self.getAllItems = getAllItems;
        self.createUser = createUser;
        self.updateUser = updateUser;
        self.removeUser = removeUser;
        self.editUser = editUser;
        self.reset = reset;
        self.addToCart = addToCart;
        self.isLimitOfItemReached = isLimitOfItemReached;
        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        
        self.reviewOrder = function(){
        	$state.go('review',{cartItems:self.cartItems});
        };
        
        self.cartClick = function(){
        	$state.go('review',{cartItems:self.cartItems});
        }
        self.cartItems = [];
        
        function getItemPrototype(item){
        	var cartItem = {
    			  	code: item.code,
    	 	        miniImageURL: item.miniImageURL,
    	 	        price: item.price,
    	 	        categoryCode: item.categoryCode,
    	 	        quantity: 1,
    	 	        itemUnitCount:item.itemUnitCount,
    	 	        finalPrice : item.price	
        	};
        	return cartItem;
        }
        
        function isLimitOfItemReached(item){
        	var limitReached = false;
        	for(var i = self.cartItems.length - 1; i >= 0; i--){
    			if(self.cartItems[i].code == item.code){
    				if((self.cartItems[i].quantity >= item.itemUnitCount)){
    					limitReached = true;
    					break;
    				}
    			}
        	} 
        	
        	return limitReached;
        }
        
        self.isItemInCart = function(item){
             	var itemAvailable = false;
             	for(var i = self.cartItems.length - 1; i >= 0; i--){
         			if(self.cartItems[i].code == item.code){
         					itemAvailable = true;
         					break;
         			}
             	} 
             	
             	return itemAvailable;  
        }
        
        function addToCart(item){
        	var alreadyPresent = false;
        	for(var i = self.cartItems.length - 1; i >= 0; i--){
    			if(self.cartItems[i].code == item.code){
    				if(! (self.cartItems[i].quantity >= item.itemUnitCount)){
    					self.cartItems[i].quantity +=1;
    					self.productCount+=1;
    					alreadyPresent = true;
    				}else{
    					alreadyPresent = true;//consider this too as already present
    					return ;
    				}
    			}
        	} 
         //push new item in cartItems
        	if(!alreadyPresent){
        		self.cartItems.push(getItemPrototype(item));
        		self.productCount+=1;
        	}        	
        }
        function submit() {
            console.log('Submitting');	
            if (self.user.id === undefined || self.user.id === null) {
                console.log('Saving New User', self.user);
                createUser(self.user);
            } else {
                updateUser(self.user, self.user.id);
                console.log('User updated with id ', self.user.id);
            }
        }

        function createUser(user) {
            console.log('About to create user');
            UserService.createUser(user)
                .then(
                    function (response) {
                        console.log('User created successfully');
                        self.successMessage = 'User created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating User');
                        self.errorMessage = 'Error while creating User: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateUser(user, id){
            console.log('About to update user');
            UserService.updateUser(user, id)
                .then(
                    function (response){
                        console.log('User updated successfully');
                        self.successMessage='User updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating User');
                        self.errorMessage='Error while updating User '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeUser(id){
            console.log('About to remove User with id '+id);
            UserService.removeUser(id)
                .then(
                    function(){
                        console.log('User '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing user '+id +', Error :'+errResponse.data);
                    }
                );
        }
        
        $scope.getItemList= function(categoryCode){
        	var promise=ItemService.loadAllItemsByCategoryCode(categoryCode);
        	
        	promise.then(function(res){
        		$scope.activeCategoryCode=categoryCode;
        		$rootScope.items=res.data;
        	})
        }

        function getAllUsers(){
            return UserService.getAllUsers();
        }

        function getAllItems() {
        	return ItemService.getAllItems();
        }
        function editUser(id) {
            self.successMessage='';
            self.errorMessage='';
            UserService.getUser(id).then(
                function (user) {
                    self.user = user;
                },
                function (errResponse) {
                    console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);