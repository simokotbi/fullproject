
$(document).ready(
    function () {
       
        $('#example').DataTable({
            ajax: {
            url: 'data.json',
            dataSrc: '',
            },
            columns: [
            { data: 'EmployeeNumber' },
            { data: 'FirstName' },
            { data: 'LastName' },
            { data: 'PhoneNumber' },
            { data: 'Email' },
            ],
            }
            );
            

    })

   