(function () {
    var module = angular.module("main_module");

    module.controller("main_ctrl", function (Contact_data) {
        this.toggleEdit = false;
        this.addButton = false;
        var self = this;
        var promise3 = Contact_data.getContacts();
        promise3.then(function (contact_data) {
            self.all_contacts = contact_data.contacts;
        });
        this.selected_contact = function (index) {
            this.select_contact = self.all_contacts[index];
            this.successMessage = undefined;
            this.errorMessage = undefined;
        }

        this.toggleEditButton = function () {
            this.toggleEdit = !this.toggleEdit;
        }

        this.toggleSaveButton = function () {
            this.toggleEdit = !this.toggleEdit;

            if (!self.addButton) {
                this.saveContact = this.select_contact;
                var promise = Contact_data.saveUserContact(this.saveContact);
                promise.then(function () {
                    self.successMessage = "Data was successfully updated";
                },
                    function () {
                        self.errorMessage = "There was an error. Please try again"
                    });
            }
            else {

                this.newContact = this.select_contact;
                var promise = Contact_data.createUserContact(this.newContact);
                promise.then(function () {
                    self.successMessage = "Data was added successfully";
                },
                    function () {
                        self.errorMessage = "There was an error. Please try again"
                    });
            }


        }

        self.addUser = function () {
            self.select_contact = {};
            self.toggleEdit = true;
            self.addButton = true;
        }
    })
})();