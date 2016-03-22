<html>
<head><title>FreeMarker Hello World SQL TEST</title>

<body>

<table class="datatable">
    <tr>
        <th>Name</th>  <th>Password</th>
    </tr>
    <#list users as user>
        <tr>
            <td>${user.firstName}</td> <td>${user.lastName}</td>
        </tr>
    </#list>





</table>

    ${table}

</body>
</html>