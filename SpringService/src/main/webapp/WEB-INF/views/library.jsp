
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Library</title>
    <link rel="stylesheet" href="<c:url value="webjars/bootstrap/4.3.1/css/bootstrap.css"/>">
</head>
<body>
<div class="jumbotron">
    <h1 class="display-4">Library!</h1>
    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    <hr class="my-4">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
</div>
<div class="container">
    <div class="row">
        <div class="col-lg-4">
            <from>
                <input type="hidden" value="0" id="id_library"/>
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" class="form-control" id="name" placeholder="enter book name"/>
                </div>

                <button type="button" class="btn btn-primary" id="save">Save/Update</button>
            </from>
        </div>
        <div class="col-lg-8">
            <div class="">
                <table class="table">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>

                    </thead>
                    <tbody class="tbl_book">

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
        resetData();
        loadData();

        var type_id=0;

        $("#save").click(function () {
            if ($("#id_library").val()==0) {
                var library = {
                    "name":$("#name").val(),

                }
                //console.log(book);
                saveDate(library);
            }else{
                _id = $("#id_library").val();
                var library = {
                    "id":_id,
                    "name":$("#name").val(),

                }
                updateBook(_id,library);
            }

        })
    })

    function resetData() {
        $("#name").val("");
        $("#id_library").val(0);

    }
    function loadData() {
        $.ajax({
            type:"GET",
            url:_host+"v1/libraries",
            success:function (response) {
                var rows = '';
                $.each(response.content, function (idx,item) {
                    rows += "<tr >";
                    rows +=" <td>"+item.id+"</td>";
                    rows +=" <td>"+item.name+"</td>";
                    rows +="   <td onclick='editBook("+item.id+")' class='btn btn-primary m-3'>Edit</td>";
                    rows +=" </tr>";
                });
                $(".tbl_book").html(rows);
            }
        });
    }

    function saveDate(_book) {
        $.ajax({
            type:"POST",
            url:_host+"v1/libraries",
            data:JSON.stringify(_book),
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


    function editBook(_id) {

        $.ajax({
            type:"GET",
            url:_host+"v1/libraries/"+_id,
            success:function (res) {
                $("#name").val(res.name),
                    $("#id_library").val(res.id)
                    // $('option:selected').val()==res.library.id?$(this).attr('selected'):"";

            }
        })
    }

    function updateBook(_id,_book) {
        $.ajax({
            type:"PUT",
            url:_host+"v1/libraries/"+_id,
            data:JSON.stringify(_book),
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


</script>
</body>
</html>