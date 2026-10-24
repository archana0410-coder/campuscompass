async function addNewDocument() {
    const title = document.getElementById('newTitle').value;
    const category = document.getElementById('newCategory').value;
    const content = document.getElementById('newContent').value;

    if (!title || !category || !content) {
        alert("Ellaa fields-um fill pannunga pa!");
        return;
    }

    const response = await fetch('/api/documents', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ title, category, content })
    });

    if (response.ok) {
        alert("Document successfully added!");
        // Clear inputs
        document.getElementById('newTitle').value = '';
        document.getElementById('newCategory').value = '';
        document.getElementById('newContent').value = '';
        // Refresh document list
        fetchDocuments();
    } else {
        alert("Failed to add document.");
    }
}