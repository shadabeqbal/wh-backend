# wh-backend
# Example Flowchart
  

Landing Page (Signup/Login)
```mermaid
flowchart TD
    A[Start] --> B{Women's Partner}
    A[Start] --> C{Women}
    A[Start] --> D{Gynecologist}
    A[Start] --> E{Fitness Trainer}
    A[Start] --> F{Pschycologist}
    A[Start] --> FF{Path Labs}

    F --> G[First Name, Last Name]
    E --> G[First Name, Last Name]
    D --> G[First Name, Last Name]
    C --> G[First Name, Last Name]
    B --> G[First Name, Last Name]
    FF --> G[First Name, Last Name]
    G --> H[Age]
    H --> I[Email Address]
    I --> J[Location/Pincode]


    D --> D.1[Years of Experience]
    D.1 --> D.2[Degree]
    F --> D.1
    E --> D.1


    

   

 