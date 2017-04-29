angular.module("main_todo",[]).controller("Main_ctrl",todo_main);

function todo_main(){
    this.button_name = "Edit";
    this.list_to_do = [
        "Learn Angular", 
        "Visit Java Brains Site", 
        "Learn more Angular"];

    this.append = function ()
    {
        this.list_to_do.push(this.input_text);
        this.input_text = "";
    };

     this.button_name_change = function ()
    {
        
        if (this.button_name=="Done")
        {
            this.button_name="Edit";
        } else
        {
            this.button_name="Done";
        }
    };

    this.delete_element = function (val)
    {
        //console.log(val);
        var index = this.list_to_do.indexOf(val);
        this.list_to_do.splice(index, 1);

    }
}