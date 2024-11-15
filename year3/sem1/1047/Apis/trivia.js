
// Define the API URL and parameters
const url = 'https://opentdb.com/api.php';
const params = new URLSearchParams({
  amount: '5',
  category: '9', // General Knowledge
  type: 'multiple',
  encode: 'url3986', // You can choose another encoding format if needed
});

// Fetch trivia questions
async function getTriviaQuestions() {
  try {
    const response = await fetch(`${url}?${params.toString()}`);
    const data = await response.json();

    if (data.response_code === 0) {
      // Loop through the results to show questions, options, and the correct answer
      data.results.forEach((question, index) => {
        // Decode the question and answers
        const decodedQuestion = decodeURIComponent(question.question);
        const decodedIncorrectAnswers = question.incorrect_answers.map(answer => decodeURIComponent(answer));
        const decodedCorrectAnswer = decodeURIComponent(question.correct_answer);

        // Combine correct and incorrect answers into one array
        const answers = [...decodedIncorrectAnswers, decodedCorrectAnswer];

        // Shuffle the answers to randomize their order
        answers.sort(() => Math.random() - 0.5);

        // Show the question
        console.log(`Q${index + 1}: ${decodedQuestion}`);

        // Show the list of answers
        answers.forEach((answer, i) => {
          console.log(`  ${i + 1}: ${answer}`);
        });

        // Find the correct answer's index in the shuffled list
        const correctAnswerIndex = answers.indexOf(decodedCorrectAnswer) + 1; // +1 to match answer number
        console.log(`Correct Answer Index (for reference): ${correctAnswerIndex}`);
        console.log('--------------------------------');
      });
    } else {
      console.log('Error fetching trivia questions:', data.response_code);
    }
  } catch (error) {
    console.error('Error fetching trivia:', error);
  }
}

// Run the function to get trivia questions
getTriviaQuestions();
