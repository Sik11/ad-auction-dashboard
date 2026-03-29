# Ad Auction Dashboard

![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)
![JavaFX](https://img.shields.io/badge/JavaFX-19-blue)
![SQLite](https://img.shields.io/badge/SQLite-3.41-lightblue?logo=sqlite)
![Maven](https://img.shields.io/badge/Maven-3.6+-red?logo=apachemaven)
![License](https://img.shields.io/badge/License-MIT-green)

A JavaFX desktop application for analyzing advertising campaign performance. Import click, impression, and server log CSV data into an embedded SQLite database, then explore key metrics and trends through interactive charts with real-time filtering.

## Architecture

```text
CSV Files ──> Database (SQLite) ──> Filter (SQL Builder) ──> Data (KPI Engine) ──> Dashboard (Charts)
```

The application follows an **MVC pattern**:

- **Models**: `Database` handles CSV import and schema creation, `Filter` builds dynamic SQL queries, `Data` computes KPIs (CTR, CPC, CPM, bounce rate, etc.), `DatabaseCache` prevents redundant queries, and `Communicator` orchestrates them all.
- **Views**: JavaFX views built with MaterialFX components and styled via swappable CSS themes. Includes dashboard, statistics, import, settings, and help screens.
- **Controllers**: Each view has a dedicated controller managing user interactions, chart updates, and filter state.

## Key Metrics

| Metric       | Description                              |
|--------------|------------------------------------------|
| Impressions  | Total ad views                           |
| Clicks       | Total ad clicks                          |
| Uniques      | Distinct users who clicked               |
| Bounces      | Single-page visits (no conversion)       |
| Conversions  | Users who completed the desired action   |
| CTR          | Click-through rate (clicks / impressions)|
| CPA          | Cost per acquisition                     |
| CPC          | Cost per click                           |
| CPM          | Cost per thousand impressions            |
| Bounce Rate  | Bounces / clicks                         |

## Prerequisites

- **JDK 17**
- **Apache Maven 3.6+**

### macOS

```bash
brew install openjdk@17 maven
```

### Windows

1. Download and install [JDK 17](https://adoptium.net/)
2. Download and install [Maven](https://maven.apache.org/download.cgi)
3. Add both to your system PATH

## Getting Started

```bash
# Clone the repository
git clone https://github.com/<your-username>/ad-auction-dashboard.git
cd ad-auction-dashboard

# Build and launch
mvn clean javafx:run
```

Maven downloads all dependencies on the first run. The application window (1200x800) opens once the build completes.

### Troubleshooting

If the build fails, verify that Maven is using JDK 17:

```bash
java -version
echo $JAVA_HOME
export JAVA_HOME=$(/usr/libexec/java_home -v 17)  # macOS only
```

## Running Tests

```bash
mvn test
```

## Sample Data

A sample 2-week campaign dataset is included in `sample-data/`. To use it:

```bash
cd sample-data
unzip 2_week_campaign_1.zip
```

This extracts a `2_week_campaign_2/` folder containing the three CSV files needed to run the application:
- `click_log.csv` — ad click records with timestamps and costs
- `impression_log.csv` — ad impression records with user demographics
- `server_log.csv` — website visit records with page views and conversions

## Usage

1. **Start Menu**: Click the import button to load campaign data.
2. **Import Data**: Select the three CSV files from `sample-data/2_week_campaign_2/` (or any compatible dataset) via the file chooser:
   - `click_log.csv`
   - `impression_log.csv`
   - `server_log.csv`
3. **Dashboard**: View all KPIs at a glance with summary cards.
4. **Charts**: Explore metrics over time. Toggle between key metrics and financial metrics, and switch time granularity (daily, weekly, monthly).
5. **Filters**: Narrow results by date range, age group, gender, income level, and context (blog, news, shopping, social media).
6. **Settings**: Customize the font, font size, and color theme (dark, forest, nebula, rose).

## Project Structure

```text
ad-auction-dashboard/
├── pom.xml                              # Maven build configuration
├── README.md
├── LICENSE
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── App.java                 # JavaFX Application entry point
│   │   │   ├── Launcher.java            # Main method
│   │   │   ├── controllers/             # 13 controller classes
│   │   │   │   ├── DashboardController  # Dashboard interactions
│   │   │   │   ├── ChartController      # Chart rendering logic
│   │   │   │   ├── StatisticsController # Statistics and filtering
│   │   │   │   ├── ImportController     # CSV file import flow
│   │   │   │   └── ...
│   │   │   ├── models/                  # 6 model classes
│   │   │   │   ├── Database             # SQLite connection, CSV import
│   │   │   │   ├── Data                 # KPI calculations
│   │   │   │   ├── Filter               # Dynamic SQL query builder
│   │   │   │   ├── Communicator         # Model orchestrator
│   │   │   │   └── ...
│   │   │   └── views/                   # 12 view classes
│   │   │       ├── DashboardView        # Main dashboard layout
│   │   │       ├── ChartView            # Chart display components
│   │   │       ├── StatisticsView       # Statistics page
│   │   │       └── ...
│   │   └── resources/
│   │       ├── dashboard.fxml           # FXML layout
│   │       ├── log4j2.xml              # Logging configuration
│   │       ├── database/sqlScripts/     # SQL schema and normalization
│   │       ├── stylesheets/             # CSS themes (dark, forest, etc.)
│   │       └── fonts/                   # Work Sans, Merriweather
│   └── test/java/
│       └── models/                      # Unit tests for Data, Database, Filter
```

## Tech Stack

| Technology    | Purpose              |
|---------------|----------------------|
| JavaFX 19     | UI framework         |
| MaterialFX    | Modern UI components |
| JFreeChart    | Chart rendering      |
| SQLite (JDBC) | Embedded database    |
| Log4j2        | Logging              |
| MyBatis       | SQL script execution |
| JUnit 4/5     | Unit testing         |

## License

This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.
