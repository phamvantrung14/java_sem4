<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>



<div class="jumbotron">
    <div class="container">
    <h1 class="display-4">Employee Manager !</h1>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <from>
                <input type="hidden" value="0" id="id_employee"/>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name"  placeholder="enter name"/>
                </div>
                <div class="form-group">
                    <label>Salary</label>
                    <input type="number" class="form-control" id="salary"  placeholder="enter salary"/>
                </div>
                <button type="button" class="btn btn-primary" id="save">Save/Update</button>
            </from>
        </div>
        <div class="col-lg-8">
            <div class="">
                <table class="table">
                    <thead>
                    <tr>
                        <th  scope="col">ID</th>
                        <th  scope="col">Name</th>
                        <th  scope="col">Salary</th>
                        <th scope="col">Action</th>
                    </tr>

                    </thead>
                    <tbody class="tbl_employee">

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
    const _host ='http://localhost:8080/api/';
    $(function () {
        loadData();
        $("#save").click(function () {
            if ($("#id_employee").val()==0) {
                var employee = {
                    "name": $("#name").val(),
                    "salary": $("#salary").val()
                }
                saveData(employee);
            }else{
                var  _id = $("#id_employee").val()
                var employee = {
                    "id":_id,
                    "name": $("#name").val(),
                    "salary": $("#salary").val()
                }
                updateEmployee(_id,employee);
            }
        })
    })


    function loadData() {
        $.ajax({
            type:"GET",
            url:_host+"v1/employee",
            success:function (response) {
                var rows = '';
                $.each(response.content, function (idx,item) {
                    rows += "<tr class='p-3'>";
                    rows +=" <th scope=\"row\">"+item.id+"</th>";
                    rows +=" <td style='width: 40%'>"+item.name+"</td>";
                    rows +=" <td>"+item.salary+"</td>";
                    rows +="   <td ><p onclick='editData("+item.id+")' class='btn btn-warning'><svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-brush-fill\" viewBox=\"0 0 16 16\">\n" +
                        "  <path d=\"M15.825.12a.5.5 0 0 1 .132.584c-1.53 3.43-4.743 8.17-7.095 10.64a6.067 6.067 0 0 1-2.373 1.534c-.018.227-.06.538-.16.868-.201.659-.667 1.479-1.708 1.74a8.118 8.118 0 0 1-3.078.132 3.659 3.659 0 0 1-.562-.135 1.382 1.382 0 0 1-.466-.247.714.714 0 0 1-.204-.288.622.622 0 0 1 .004-.443c.095-.245.316-.38.461-.452.394-.197.625-.453.867-.826.095-.144.184-.297.287-.472l.117-.198c.151-.255.326-.54.546-.848.528-.739 1.201-.925 1.746-.896.126.007.243.025.348.048.062-.172.142-.38.238-.608.261-.619.658-1.419 1.187-2.069 2.176-2.67 6.18-6.206 9.117-8.104a.5.5 0 0 1 .596.04z\"/>\n" +
                        "</svg> Edit</p></td>";
                    rows +=" </tr>";
                });
                $(".tbl_employee").html(rows);
            }
        });
    }

    function saveData(_employee) {
        $.ajax({
            type:"POST",
            url:_host+"v1/employee",
            data:JSON.stringify(_employee),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success:function (res) {
                loadData();
                resetData();
            }
        })
    }

    function editData(_id) {
        $.ajax({
            type:"GET",
            url:_host+"v1/employee/"+_id,
            success:function (res) {
                $("#name").val(res.name),
                $("#id_employee").val(res.id),
                $("#salary").val(res.salary)
            }
        })
    }
    function updateEmployee(_id,_employee) {
        $.ajax({
            type:"PUT",
            url:_host+"v1/employee/"+_id,
            data:JSON.stringify(_employee),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success:function (res) {
                loadData();
                resetData();

            }
        })
    }
    function deleteEmployee(_id) {
        $.ajax({
            type:"DELETE",
            url:_host+"v1/employee/"+_id,
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success:function (res) {
                loadData();
            }
        })
    }
    function resetData() {
        $("#name").val("");
        $("#salary").val("");
        $("#id_employee").val("");
    }
</script>

</body>
</html>