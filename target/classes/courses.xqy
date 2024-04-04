let $courses := (doc("course.xml")/courses/course)  
return <results>  
{  
   for $x in $courses  
   where $x/fees>2000  
   order by $x/fees  
   return $x/title  
}  
</results>  