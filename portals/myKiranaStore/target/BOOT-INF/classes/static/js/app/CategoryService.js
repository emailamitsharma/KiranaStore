'use strict';

angular.module('kiranaApp').factory('CategoryService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllCategories: loadAllCategories,
                getAllCategories: getAllCategories
            };

            return factory;

            function loadAllCategories() {
                console.log('Fetching all categories');
                var deferred = $q.defer();
                $http.get(urls.CATEGORY_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all categories');
                            $localStorage.categories = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading categories');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllCategories(){
                return $localStorage.categories;
            }
        }
    ]);