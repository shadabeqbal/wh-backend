# wh-backend
# Example Flowchart
Women
```mermaid
flowchart TD
    A[Start] --> B{Women}
    A[Start] --> C{Gynecologist}
    A[Start] --> D{Fitness Trainer}
    A[Start] --> E{Pschycologist}
    A[Start] --> F{Path Labs}
    B -->|Yes| C[Continue]
    B -->|No| D[Fix it]
    D --> E{Fixed?}
    E -->|Yes| C[Continue]
    E -->|No| F[Retry]
    F --> D
    C --> G[Finish]

 