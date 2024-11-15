//async function query(data) {
//	const response = await fetch(
//		"https://api-inference.huggingface.co/models/sentence-transformers/all-MiniLM-L6-v2",
//		{
//			headers: {
//				Authorization: "Bearer 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",
//				"Content-Type": "application/json",
//			},
//			method: "POST",
//			body: JSON.stringify(data),
//		}
//	);
//	const result = await response.json();
//	return result;
//}

//query({"inputs": {
//	"source_sentence": "That is a happy person",
//	"sentences": [
//		"That is a happy dog",
//		"That is a very happy person",
//		"Today is a sunny day"
//	]
//}}).then((response) => {
//	console.log(JSON.stringify(response));
//});




//async function query(data) {
//	try {
//		const response = await fetch(
//			"https://api-inference.huggingface.co/models/sentence-transformers/all-MiniLM-L6-v2",
//			{
//				headers: {
//					Authorization: "Bearer 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",
//					"Content-Type": "application/json"
//				},
//				method: "POST",
//				body: JSON.stringify(data)
//			}
//		);

//		if (!response.ok) {
//			throw new Error(`HTTP error! status: ${response.status}`);
//		}

//		const result = await response.json();
//		return result;
//	} catch (error) {
//		console.error("Error querying the API:", error);
//		return null;
//	}
//}

//// Example usage of the query function
//query({
//	"inputs": {
//		"source_sentence": "That is a happy person",
//		"sentences": [
//			"That is a happy dog",
//			"That is a very happy person",
//			"Today is a sunny day"
//		]
//	}
//}).then((response) => {
//	if (response) {
//		console.log(JSON.stringify(response, null, 2));
//	}
//});


//
// Import node-fetch to use fetch in Node.js
//const fetch = require("node-fetch");

// Replace with your actual Hugging Face API token
const API_URL = "https://api-inference.huggingface.co/models/sentence-transformers/all-MiniLM-L6-v2";
const headers = {
    Authorization: "Bearer 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",
    "Content-Type": "application/json"
};

// Define the query function
async function query(data) {
    try {
        const response = await fetch(API_URL, {
            headers: headers,
            method: "POST",
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result = await response.json();
        return result;
    } catch (error) {
        console.error("Error querying the API:", error);
    }
}

// Define the payload
const payload = {
    "inputs": {
        "source_sentence": "That is a happy person",
        "sentences": [
            "That is a happy dog",
            "That is a very happy person",
            "Today is a sunny day"
        ]
    }
};

// Run the query and format the output
query(payload).then((scores) => {
    if (scores && Array.isArray(scores)) {
        payload.inputs.sentences.forEach((sentence, index) => {
            console.log(`"${sentence}": ${scores[index]}`);
        });
    } else {
        console.log("Unexpected response format:", scores);
    }
});
