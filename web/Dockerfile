# Stage 1: Build the React app using Yarn
FROM node:18-alpine as build

# Set working directory
WORKDIR /app

# Copy the package.json and yarn.lock into the container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the app into the container
COPY . .

# Increase memory limit
ENV NODE_OPTIONS="--max-old-space-size=4096"

# Arguments
# ARG REACT_APP_API_URL

# Environment
# ENV REACT_APP_API_URL=${REACT_APP_API_URL}

# Build the React app
RUN npm run build

# Stage 2: Serve the app with NGINX
FROM nginx:1.23-alpine

# Remove default NGINX website
RUN rm -rf /usr/share/nginx/html/*

# Copy the built React app from the first stage
COPY --from=build /app/dist /usr/share/nginx/html

# Copy custom NGINX configuration
COPY nginx.conf /etc/nginx/conf.d/default.conf

# Expose the port NGINX is running on
EXPOSE 80

# Start NGINX
CMD ["nginx", "-g", "daemon off;"]
