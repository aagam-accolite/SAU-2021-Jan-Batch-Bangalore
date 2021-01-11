function validateForm(event) {
    event.preventDefault();
    var firstName = document.forms["myForm"]["fname"].value;
    var lastName = document.forms["myForm"]["lname"].value;
    var email_Id = document.forms["myForm"]["email"].value;
    var gender = document.forms["myForm"]["gender"].value;
    var officeLocation = document.forms["myForm"]["location"].value;
    var regex = new RegExp("[a-zA-Z0-9]+@[|a-zA-Z]*.[com|edu]");
    if (firstName == '') {
        alert('Please Enter the First Name');
    }
    else if (lastName == '') {
        alert('Please Enter the Last Name');
    }
    else if (gender == '')
    {
        alert('Please Select a Gender');
    }
    else if(!regex.test(email_Id))
    {
        alert('Please Enter a Valid Email Id');
    }
    else if(officeLocation == '')
    {
        alert('Please Select an Office Location');
    }
    else{
        var jsonobj =JSON.parse(JSON.stringify('{"firstName" :' + firstName + ', "lastName" : ' + lastName + ' ,"emailId" : ' + document.forms["myForm"]["email"].value +
        ', "gender" : '+ gender + ', "officeLocation" : ' + officeLocation + '}'));
        console.log(jsonobj);
    }
  }