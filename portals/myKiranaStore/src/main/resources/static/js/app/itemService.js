'use strict';

angular.module('kiranaApp').factory('ItemService',
    ['$localStorage', '$http', '$q', 'urls','$rootScope',
        function ($localStorage, $http, $q, urls,$rootScope) {

            var factory = {
                loadAllItems: loadAllItems,
                getAllItems: getAllItems,
                loadAllItemsByCategoryCode : loadAllItemsByCategoryCode
            
            };

            return factory;
            function loadAllItems() {
            	return loadAllItemsByCategoryCode( $localStorage.categories[0].code);
            }
            function loadAllItemsByCategoryCode(categoryCode) {
                console.log('Fetching all items by category Code : '+categoryCode);
                var deferred = $q.defer();
                $http.get(urls.ITEM_SERVICE_API + categoryCode)
                    .then(
                        function (response) {
                            $localStorage.items = response.data;
                            $rootScope.items=response.data;
                            console.log('Fetched successfully all items where item count = '+$localStorage.items.length);
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading items');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllItems(){
                return $localStorage.items;
            }
        }
    ]);