The Secure File Access and Sharing System is a Java-based application that allows users to securely store, access, and share files within an organization. The system is developed using a 4-layer architecture (Model, DAO, Service, Controller) with JDBC for database communication, ensuring a clean separation of concerns and easy maintenance.

User Authentication: Only registered users can log in and access files.

File Upload & Retrieval: Users can upload files, which are stored with encryption for security, and retrieve them later.

Access Control: File sharing is role-based (e.g., admin, user) to prevent unauthorized access.

Audit Logs: Tracks who uploaded, accessed, or shared each file.

Database Integration (JDBC): User credentials, file metadata, and sharing permissions are managed in a relational database (e.g., MySQL).

This layered approach improves scalability, security, and maintainability, making the system reliable for controlled file sharing in secure environments.
