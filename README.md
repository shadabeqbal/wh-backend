# wh-backend
# Example Flowchart
   %%{init: {'theme': 'base', 'themeVariables': { 'boxBkgColor': '#f9f9f9', 'boxBorderColor': '#999', 'boxBorderStyle': 'dotted'}}}%%

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


    D --> D.1{Years of Experience}


graph TD
    A[Start] --> B[Step 1]
    B --> C[Step 2]
    C --> D[End]

    classDef dottedBox fill:#f9f9f9,stroke:#999,stroke-dasharray: 3 3;
    class A,B,C,D dottedBox;


   

 