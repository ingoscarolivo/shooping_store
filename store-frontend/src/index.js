import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import { QueryClient, QueryClientProvider } from "react-query";
import reportWebVitals from './reportWebVitals';
const client = new QueryClient();

ReactDOM.render(
  <QueryClientProvider client={client}>
    
  </QueryClientProvider>,
  document.getElementById("root")
);


reportWebVitals();
