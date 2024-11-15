
//async function query(data) {
//	const response = await fetch(
//		"https://api-inference.huggingface.co/models/1231czx/llama3_it_ultra_list_and_bold500",
//		{
//			headers: {
//				Authorization: "Bearer ",
//				"Content-Type": "application/json",
//			},
//			method: "POST",
//			body: JSON.stringify(data),
//		}
//	);
//	const result = await response.json();
//	return result;
//}

//query({"inputs": "I like you. I love you"}).then((response) => {
//	console.log(JSON.stringify(response));
//});



async function query(data) {
	const response = await fetch(
	  "https://api-inference.huggingface.co/models/1231czx/llama3_it_ultra_list_and_bold500", // The model URL
	  {
		headers: {
		  Authorization: "Bearer ", // Your Hugging Face API token
		  "Content-Type": "application/json",
		},
		method: "POST",
		body: JSON.stringify(data),
	  }
	);
  
	const result = await response.json();
	return result;
  }
  
  // Example trivia question and answer choices
  const triviaQuestion = "What is the capital of France?";
  const answerChoices = ["London", "Berlin", "Paris", "Madrid"];
  
  // Format the input for the model (including the question and answer choices)
  const data = {
	inputs: `Question: ${triviaQuestion}\nChoices: ${answerChoices.join(", ")}\nPlease choose the correct answer.`,
  };
  
  query(data).then((response) => {
	console.log("Response:", JSON.stringify(response, null, 2));
  
	// Assuming the model returns an answer (check the structure of the response)
	if (response && response.generated_text) {
	  console.log("Generated answer:", response.generated_text);
	}
  });
  