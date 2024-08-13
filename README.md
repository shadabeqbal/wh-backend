# wh-backend
# Example Flowchart
Women
```mermaid
flowchart TD
    A[Start] --> B{Women}
    A[Start] --> B{Gynecologist}
    A[Start] --> B{Fitness Trainer}
    A[Start] --> B{Pschycologist}
    A[Start] --> B{Path Labs}
    B -->|Yes| C[Continue]
    B -->|No| D[Fix it]
    D --> E{Fixed?}
    E -->|Yes| C[Continue]
    E -->|No| F[Retry]
    F --> D
    C --> G[Finish]

 