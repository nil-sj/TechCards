import React from 'react'
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";

const Feed = () => {


  const resources = [
    {
      title: "Resource 1",
      description: "A comprehensive guide on React.",
      image: "https://th.bing.com/th/id/OIP.Hoolu4Gp7r5UgcPYbImNQgAAAA?rs=1&pid=ImgDetMain"
    },
    {
      title: "Resource 2",
      description: "JavaScript advanced patterns.",
      image: "https://th.bing.com/th/id/OIP.VNj0AVUKQM1t8ZnUdF_6WQHaEK?rs=1&pid=ImgDetMain"
    },
    {
      title: "Resource 3",
      description: "Mastering the DOM.",
      image: "https://i.ytimg.com/vi/4DUX-Uzddus/maxresdefault.jpg"
    },
    {
      title: "Resource 4",
      description: "CSS Grid and Flexbox.",
      image: "https://th.bing.com/th/id/OIP.nNuAdt5XRB13oT8rgwXh7wAAAA?rs=1&pid=ImgDetMain"
    },
    {
      title: "Resource 5",
      description: "Node.js and Express.",
      image: "https://i.ytimg.com/vi/ipOYH_Wi9Xw/maxresdefault.jpg"
    },
    {
      title: "Resource 6",
      description: "Introduction to Machine Learning.",
      image: "https://prod-discovery.edx-cdn.org/media/course/image/3e45c431-10df-423e-9f03-fb98b713cd4a-5158ac9c653a.small.png"
    },
    {
      title: "Resource 7",
      description: "Web development best practices.",
      image: "https://th.bing.com/th/id/OIP.AtPdSWcX3aTmYQEszlvcdgAAAA?rs=1&pid=ImgDetMain"
    },
    {
      title: "Resource 8",
      description: "React with Redux.",
      image: "https://th.bing.com/th/id/OIP.dqi4byUkKDYKBUA5bSWQYgHaFR?rs=1&pid=ImgDetMain"
    },
    {
      title: "Resource 9",
      description: "Introduction to TypeScript.",
      image: "https://th.bing.com/th/id/OIP.7rtfbsqxqBOstNzzclZGGwHaDt?rs=1&pid=ImgDetMain"
    }
  ];

  return (
      <Card className="p-4 grid grid-cols-3 gap-4 border-0 md:border h-full w-full rounded-none md:rounded-xl">
        {resources.map((resource, index) => (
           <Card key={index}>
           <CardHeader>
             <CardTitle>{resource.title}</CardTitle>
             <CardDescription>{resource.description}</CardDescription>
           </CardHeader>
           <CardContent>
             <img src={resource.image} alt={resource.title} className="w-full h-auto" />
           </CardContent>
           <CardFooter>
             <p>Explore more resources</p>
           </CardFooter>
         </Card>
       ))}     
      </Card>
  )
}

export default Feed