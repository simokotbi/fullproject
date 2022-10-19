$(document).ready(
    function () {
        var par = document.createElement("a");
        var text = document.createTextNode("HOME");
        par.appendChild(text);
        par.classList.add('homeBtn')
        par.setAttribute('href',"Index.html")
        document.body.appendChild(par);
        $('body').addClass('day1')




        
    // $('#example').DataTable({
    //     ajax: {
    //     url: 'data.json',
    //     dataSrc: '',
    //     },
    //     columns: [
    //     { data: 'EmployeeNumber' },
    //     { data: 'FirstName' },
    //     { data: 'LastName' },
    //     { data: 'PhoneNumber' },
    //     { data: 'Email' },
    //     ],
    //     }
    //     );
        });
    
        // $('#dayNightBtn').on('click',function(){
        //     var mod = $(this).attr('data-mod')
        //     console.log('OK');
        //     if(mod == 'day')
        //     {
        //      $('body').removeClass('day1').addClass('night1') 
        //      $(this).attr('data-mod','night')
        //     }else{
        //         $('body').removeClass('night1').addClass('day1')   
        //         $(this).attr('data-mod','day')
        //     }
    
    
        // })
    