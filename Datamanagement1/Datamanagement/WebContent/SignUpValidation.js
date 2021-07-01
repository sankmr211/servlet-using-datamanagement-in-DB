function Validation()
{
if(document.reg.uname.value=="")
{
alert("enter the username");
return false;
}
else if(document.reg.upass.value=="")
	{
	alert("enter the password");
	return false;
	}
else if(document.reg.upass.value!=document.reg.rpass.value)
	{
	alert("Password Does not match");
	return false;
	}
else if(document.reg.gen[0].checked==false&&document.reg.gen[1].checked==false)
	{
	alert("Select the gender");
	return false;
	}
else if(document.reg.cntry.value=="0")
	{
	alert("select the contry");
	return false;
	}
else if(document.reg.umbno.value=="")
	{
	alert("enter the mobile number");
	return false;
	}
else if(document.reg.umbno.value.length!=9)
	{
	alert("enter the 9 Digit Mobile No");
	return false;
	}
else if(isNaN(document.reg.umbno.value))
		{
	alert("enter the valid Mobile No");
	return false;
		}
else if(document.reg.addr.value=="")
	{
	alert("enter the address");
	return false;
	}
else
{
alert("register successfully...!");
return true;
}
}