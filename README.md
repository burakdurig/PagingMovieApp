High Level: 
- MVVM + Paging Library + Retrofit + Dagger Hilt
- View: Activity/Fragment (Main Activity) => 
- View Model: ViewModel with LiveData 3 => 
- Model: Repository => Remote Data Source using Retrofit => Web service

Paging Library:
- In-memory caching for paged data. To optimize systems efficiently
- Built-in request deduplication
- Configurable RecyclerView adapters that automatically request data as the user scrolls.
- Built-in support for error handling

Structure:
1. Paged List Adapter : Replaces RecyclerView.Adapter Class
2. Paged List: Loading Data Automatically
3. Data Source: An interface for Data providing (divided into three parts)
    1. PageKeyedDataSource: Passing page number as a query parameter in the request (work accordingly to the pages) [we will be using this type of datasource in this application]
    2. ItemKeyedDataSource: Fetch data using a key belong to item. Ex: fetch movie acc. To ID
    3. PositionalDataSource: Fetch items with arbitrary positions

Migrating from Paging 2 to Paging 3:
PagedListAdapter (2.0)     => PagingDataAdapter (3.0)
DiffUtil.ItemCallback (2.0) => DiffUtil.ItemCallback (3.0
DataSource (2.0)                => PagingSource (3.0)
DataSource.Factory (2.0)
LivePagedListBuilder (2.0) => Pager (3.0)
PagedList.Config (2.0)        => PagingConfig (3.0)



Credits go to Abbass Masri
from The Complete Android 14 Developer Course
