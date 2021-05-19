
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
    <h1 class="display-4">Book!</h1>
    <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
    <hr class="my-4">
    <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
    <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
</div>
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <from>
                    <input type="hidden" value="0" id="id_book"/>
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" id="name" placeholder="enter book name"/>
                    </div>
                    <div class="form-group">
                        <label>Library</label>
                        <select class="library1 form-control" id="library1">

                        </select>
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
       loadLibrary();
       var type_id=0;
       $("select.library1").change(function () {
           //alert($("option:selected").val());
           type_id = $("option:selected").val();
       });

       $("#save").click(function () {
            if ($("#id_book").val()==0) {
                var book = {
                    "name":$("#name").val(),
                    "library":{
                        id:type_id
                    }
                }
                //console.log(book);
                saveDate(book);
            }else{
                _id = $("#id_book").val();
                var book = {
                    "id":_id,
                    "name":$("#name").val(),
                    "library":{
                        id:type_id
                    }
                }
                updateBook(_id,book);
            }

       })
   })

function resetData() {
    $("#name").val("");
    $("#id_book").val(0)

    $( "#library1 option" ).each(function () {

        if ($(this).val()==0)
        {
            $(this).removeAttr('selected');
        }

    });
}
    function loadData() {
        $.ajax({
            type:"GET",
            url:_host+"v1/books",
            success:function (response) {
                var rows = '';
                $.each(response.content, function (idx,item) {
                    rows += "<tr >";
                    rows +=" <td>"+item.id+"</td>";
                    rows +=" <td>"+item.name+"</td>";
                    rows +="   <td onclick='editBook("+item.id+")' class='btn btn-primary m-3'>Edit</td>";
                    rows +="   <td onclick='deleteBook("+item.id+")' class='btn btn-danger m-3'>Delete</td>";
                    rows +=" </tr>";
                });
                $(".tbl_book").html(rows);
            }
        });
    }
    
    function saveDate(_book) {
        $.ajax({
            type:"POST",
            url:_host+"v1/books",
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
    
    function loadLibrary() {
        $.ajax({
            type: "GET",
            url: _host+"v1/libraries",
            success:function (res) {
               // console.log(res);
                var rows ='<option value="0" >--chose--</option>';
                $.each(res.content, function (idx,item) {
                    rows +="<option  value='"+item.id+"'>"+item.name+"</option>"
                });
                $("#library1").html(rows);
            }
        })
    }

    function editBook(_id) {
       loadLibrary();
        $.ajax({
            type:"GET",
            url:_host+"v1/books/"+_id,
            success:function (res) {
                $("#name").val(res.name),
                $("#id_book").val(res.id),
               // $('option:selected').val()==res.library.id?$(this).attr('selected'):"";
                $( "#library1 option" ).each(function () {
                    if ($(this).val()==res.library.id)
                    {
                        $(this).attr('selected','');
                    }
                    if ($(this).val()!=res.library.id)
                    {
                        $(this).removeAttr('selected');
                    }

                });
            }
        })
    }

    function updateBook(_id,_book) {
        $.ajax({
            type:"PUT",
            url:_host+"v1/books/"+_id,
            data:JSON.stringify(_book),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success:function (res) {
                loadData();
                loadLibrary();
                resetData();

            }
        })
    }

    function deleteBook(_id) {
        $.ajax({
            type:"DELETE",
            url:_host+"v1/books/"+_id,
            success:function (res) {
                loadData();
                loadLibrary();
                resetData();

            }
        })
    }
</script>
</body>
</html>