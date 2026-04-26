def bublesort(arr):
    for i in range(len(arr)):
        for j in range(0, len(arr) - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

def heapify(arr, n, i):
    larg = i
    left = 2 * i + 1
    right = 2 * i + 2

    if left < n and arr[left] > arr[larg]:
        larg = left
    if right < n and arr[right] > arr[larg]:
        larg = right
    if larg != i:
        arr[i], arr[larg] = arr[larg], arr[i]
        heapify(arr, n, larg)

def heapsort(arr):
    n = len(arr)

    for i in range(n // 2 - 1, -1, -1):
        heapify(arr, n, i)
    
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, i, 0)
    return arr

def mergesort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_haf = arr[mid:]

        mergesort(left_half)
        mergesort(right_haf)

        i = j = k = 0

        while i < len(left_half) and j < len(right_haf):
            if left_half[i] < right_haf[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_haf[j]
                j += 1
            k += 1
        
        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1
        while j < len(right_haf):
            arr[k] = right_haf[j]
            j += 1
            k += 1
        
        return arr

def quicksort(arr):
    if len(arr) < 1:
        return arr
    
    pivot = arr[len(arr) // 2]

    leftt = [x for x in arr if x < pivot]
    mid = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return quicksort(leftt) + mid + quicksort(right)

def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

def binaryseach(arr, target):
    low = 0
    high = len(arr) - 1

    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1



arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
print(f"binary:  {binaryseach(arr, 19)}")
print(f"linear  {linear_search(arr, 19)}")
