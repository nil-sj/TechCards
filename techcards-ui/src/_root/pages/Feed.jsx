import React, {useState, useEffect} from 'react'
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import axios from 'axios';

const Feed = () => {

  const [resources, setResources] = useState([]); 
  const [isLoading, setIsLoading] = useState(true); 
  const [error, setError] = useState(null);
  
  useEffect(() => {
    
    const fetchResources = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/techcards');
        setResources(response.data);
      } catch (err) {
        console.error('Error fetching TechCards:', err);
        setError('Failed to fetch resources. Please try again later.');
      } finally {
        setIsLoading(false); 
      }
    };

    fetchResources();
  }, []); 

  return (
      <Card className="p-4 overflow-y-scroll scrollbar-custom grid grid-cols-3 gap-4 border-0 md:border h-full w-full rounded-none md:rounded-xl">
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