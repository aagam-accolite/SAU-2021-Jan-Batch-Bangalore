class Student{
    constructor(firstName, lastName, age, gender, rollNo, email, branch, Occupation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.rollNo = rollNo;
        this.email = email;
        this.branch = branch;
        this.occupation = Occupation;
    }
}
const Submit = (event) =>{
    event.preventDefault();
    var firstName = document.forms["myForm"]["firstName"].value;
    var lastName = document.forms["myForm"]["lastName"].value;
    var age = (document.forms["myForm"]["age"].value);
    var gender = document.forms["myForm"]["gender"].value;
    var email_Id = document.forms["myForm"]["email"].value;
    var roll_no = document.forms["myForm"]["rollNo"].value;
    var branch = document.forms["myForm"]["brach"].value;

    var regex = new RegExp("[a-zA-Z0-9]+@[|a-zA-Z]*.[com|edu]");
    if(firstName == '')
    {
        alert('Enter First Name');
    }
    else if(lastName == '')
    {
        alert('Enter Last Name');
    }
    else if(isNaN(age) || age < 1 || age > 100)
    {
        alert('Enter Valid Age');
    }
    else if(gender == '')
    {
        alert('Enter Gender');
    }
    else if(!regex.test(email_Id))
    {
        alert('Please Enter a Valid Email Id');
    }
    else if(roll_no < 0 && roll_no != '' )
    {
        alert('Enter Roll No');
    }
    else if(branch == '')
    {
        alert('Enter Branch');
    }
    else{
        occupation = null;
        var obj = new Student(firstName, lastName, age, gender, roll_no, email_Id,branch,occupation);
        display(obj);
        console.log(obj);
    }
}

function display(obj) 
{
    document.getElementById("fnameOutput").innerHTML = (obj.firstName);
    document.getElementById("lnameOutput").innerHTML = (obj.lastName);
    document.getElementById("ageOutput").innerHTML = (obj.age);
    document.getElementById("emailOutput").innerHTML = (obj.email);
    document.getElementById("genderOutput").innerHTML = (obj.gender);
    document.getElementById("rollOutput").innerHTML = (obj.rollNo);
    document.getElementById("branchOutput").innerHTML = (obj.branch);
    displayOccupation()
}

// IIFE 
function displayOccupation() {
    var occupation = (() => {
        document.getElementById("roll_no_lbl").style.display = "block";
        document.getElementById("roll_No_inp").style.display = "block";
        document.getElementById("occupationbtn").style.display = "block";
        document.getElementById("occupationlbl").style.display = "block";
        document.getElementById("occupationinp").style.display = "block";
        console.log("occupation shown");
    })();
}

function addOccupation(){
    console.log('Occupation Added')
    var roll_no = document.getElementById('roll_No_inp').value;
    if(roll_no != this.rollNo)
    {
        alert('Roll No not Found');
    }
    else{
        var occ = document.getElementById('occupationinp').value;
        this.occupation = occ;
        document.getElementById("occshw").style.display = "block";
        document.getElementById('occupationOutput').innerHTML = this.occupation;
    }
   
} 